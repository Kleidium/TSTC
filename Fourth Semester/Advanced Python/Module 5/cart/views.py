from django.shortcuts import render, get_object_or_404
from django.http import JsonResponse
from .cart import Cart
from shop.models import Design


# Create your views here.
def cart_summary(request):
	cart = Cart(request)
	return render(request, 'shop/cart/summary.html', {'cart': cart})

def cart_add(request):
	cart = Cart(request)
	if request.POST.get('action') == 'post':
		# Design Properties #
		design_id = int(request.POST.get('designid'))
		design_qty = int(request.POST.get('designqty'))
		design_size = str(request.POST.get('designsize'))
		design_material = str(request.POST.get('designmaterial'))
		design_color = str(request.POST.get('designcolor'))
		design = get_object_or_404(Design, id=design_id)
		cart.add(design=design, qty=design_qty, size=design_size, material=design_material, color=design_color)

		# Cart Total #
		cart_qty = cart.__len__()
		response = JsonResponse({'qty': cart_qty})
		return response
	
def cart_delete(request):
	cart = Cart(request)
	if request.POST.get('action') == 'post':
		design_id = int(request.POST.get('designid'))
		cart.delete(design=design_id)

		cart_qty = cart.__len__()
		cart_total = cart.get_total_price()
		response = JsonResponse({'qty': cart_qty, 'subtotal':cart_total})
		return response
	
def cart_update(request):
	cart = Cart(request)
	if request.POST.get('action') == 'post':
		# Design Properties #
		design_id = int(request.POST.get('designid'))
		design_qty = int(request.POST.get('designqty'))
		design_size = str(request.POST.get('designsize'))
		design_material = str(request.POST.get('designmaterial'))
		design_color = str(request.POST.get('designcolor'))
		design = get_object_or_404(Design, id=design_id)
		itemtotal = design.price * design_qty
		cart.update(design=design_id, quantity=design_qty, size=design_size, material=design_material, color=design_color)

		# Cart Total #
		cart_qty = cart.__len__()
		cart_total = cart.get_total_price()
		response = JsonResponse({'qty': cart_qty, 'subtotal':cart_total, 'itemtotal':itemtotal})
		return response