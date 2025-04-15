from shop.models import Design
from decimal import Decimal

class Cart():

	def __init__(self, request):
		self.session = request.session
		cart = self.session.get('skey')

		if 'skey' not in request.session:
			cart = self.session['skey'] = {}

		self.cart = cart

	def add(self, design, qty, size, material, color):
		# Adding and updating the user's cart session data
		design_id = str(design.id)

		if design_id in self.cart:
			self.cart[design_id]['qty'] = qty
			self.cart[design_id]['size'] = size
			self.cart[design_id]['material'] = material
			self.cart[design_id]['color'] = color
		else:
			self.cart[design_id] = {'price': str(design.price), 'qty':int(qty), 'size': str(size), 'material': str(material), 'color': str(color)}
		
		self.save()

	def __len__(self):
		# Get the cart data and count the quantity of items
		return sum(item['qty'] for item in self.cart.values())
	
	def __iter__(self):
		# Collect the design_id in the session data to query the database and return products
		design_ids = self.cart.keys()
		designs = Design.designs.filter(id__in=design_ids)
		cart = self.cart.copy()

		for design in designs:
			cart[str(design.id)]['design'] = design

		for item in cart.values():
			item['price'] = Decimal(item['price'])
			item['total_price'] = item['price'] * item['qty']
			yield item
	
	def get_total_price(self):
		# Returns price * quantity of the items and adds them together to make a subtotal. Returns a formatted string.
		subtotal = sum(Decimal(item['price']) * item['qty'] for item in self.cart.values())

		return str(format(subtotal, ',.2f'))
	
	def delete(self, design):
		# Delete item from session data
		design_id = str(design)

		if design_id in self.cart:
			del self.cart[design_id]
		
		self.save()

	def update(self, design, quantity, size, material, color):
		# Update values in session data
		design_id = str(design)

		if design_id in self.cart:
			self.cart[design_id]['qty'] = quantity
			self.cart[design_id]['size'] = size
			self.cart[design_id]['material'] = material
			self.cart[design_id]['color'] = color
			
		self.save()
	
	def save(self):
		self.session.modified = True