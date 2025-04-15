from django import forms
from .models import UserBase
from django.contrib.auth.forms import AuthenticationForm, PasswordResetForm, SetPasswordForm
from django_countries.fields import CountryField
from django_countries.widgets import CountrySelectWidget


class UserLoginForm(AuthenticationForm):
	username = forms.CharField(widget=forms.TextInput(attrs={'class': 'form-control mb-3', 'placeholder': 'Username', 'id': 'login-username'}))
	password = forms.CharField(widget=forms.PasswordInput(attrs={'class': 'form-control', 'placeholder': 'Password', 'id': 'login-pwd'}))

class RegistrationForm(forms.ModelForm):
	user_name = forms.CharField(label='Username', min_length=4, max_length=50, help_text='Required')
	email = forms.EmailField(max_length=100, help_text='Required', error_messages={'required': 'An email address is required.'})
	password = forms.CharField(label='Password', min_length=8, max_length=50, widget=forms.PasswordInput)
	password2 = forms.CharField(label='Repeat Password', min_length=8, max_length=50, widget=forms.PasswordInput)

	class Meta:
		model = UserBase
		fields = ('user_name', 'email',)

	def clean_username(self):
		user_name = self.cleaned_data['user_name'].lower()
		r = UserBase.objects.filter(user_name=user_name)

		if r.count():
			raise forms.ValidationError("Username already exists.")
		
		return user_name
	
	def clean_password2(self):
		cd = self.cleaned_data

		if cd['password'] != cd['password2']:
			raise forms.ValidationError('Passwords do not match.')
		
		return cd['password2']
	
	def clean_email(self):
		email = self.cleaned_data['email']

		if UserBase.objects.filter(email=email).exists():
			raise forms.ValidationError('An account with this email already exists.')
		
		return email
	
	def __init__(self, *args, **kwargs):
		super().__init__(*args, **kwargs)
		
		self.fields['user_name'].widget.attrs.update({'class': 'form-control mb-3', 'placeholder': 'Username'})
		self.fields['email'].widget.attrs.update({'class': 'form-control mb-3', 'placeholder': 'Email', 'name': 'email', 'id': 'id_email'})
		self.fields['password'].widget.attrs.update({'class': 'form-control mb-3', 'placeholder': 'Password'})
		self.fields['password2'].widget.attrs.update({'class': 'form-control', 'placeholder': 'Repeat Password'})

class UserEditForm(forms.ModelForm):
	# Required, Read Only
	email = forms.EmailField(
		label='Account Email', max_length=100, widget=forms.TextInput(attrs={'class': 'form-control mb-3 read-only', 'placeholder': 'Email', 'id': 'form-email', 'readonly': 'readonly'}))

	user_name = forms.CharField(
		label='Username', min_length=4, max_length=50, widget=forms.TextInput(attrs={'class': 'form-control mb-3 read-only', 'placeholder': 'Username', 'id': 'form-user_name', 'readonly': 'readonly'}))

	# Optional
	first_name = forms.CharField(label='First Name', max_length=50, widget=forms.TextInput(attrs={'class': 'form-control mb-3', 'id': 'form-first_name'}))
	last_name = forms.CharField(label='Last Name', max_length=50, widget=forms.TextInput(attrs={'class': 'form-control mb-3', 'id': 'form-last_name'}))
	about = forms.CharField(label='About', max_length=500, widget=forms.Textarea(attrs={'class': 'form-control mb-3', 'id': 'form-about'}))
	phone = forms.CharField(label='Phone Number', max_length=20, widget=forms.TextInput(attrs={'class': 'form-control mb-3', 'id': 'form-phone'}))
	address_1 = forms.CharField(label='Address Line 1', max_length=150, widget=forms.TextInput(attrs={'class': 'form-control mb-3', 'id': 'form-address_1'}))
	address_2 = forms.CharField(label='Address Line 2', max_length=150, widget=forms.TextInput(attrs={'class': 'form-control mb-3', 'id': 'form-address_2'}))
	city = forms.CharField(label='City', max_length=150, widget=forms.TextInput(attrs={'class': 'form-control mb-3', 'id': 'form-city'}))
	state = forms.CharField(label='State/Province', max_length=150, widget=forms.TextInput(attrs={'class': 'form-control mb-3', 'id': 'form-state'}))
	zipcode = forms.CharField(label='Zipcode', max_length=12, widget=forms.TextInput(attrs={'class': 'form-control mb-3', 'id': 'form-zipcode'}))
	country = CountryField()

	class Meta:
		model = UserBase
		fields = ('email', 'user_name', 'first_name', 'last_name', 'about', 'phone', 'zipcode', 'address_1', 'address_2', 'city', 'state', 'country')
		widgets = {'country': CountrySelectWidget(attrs={'class': 'form-control mb-3'})}	# Widget required for form-control styling.

	def __init__(self, *args, **kwargs):
		super().__init__(*args, **kwargs)

		self.fields['user_name'].required = True
		self.fields['email'].required = True
		self.fields['first_name'].required = False
		self.fields['last_name'].required = False
		self.fields['about'].required = False
		self.fields['phone'].required = False
		self.fields['address_1'].required = False
		self.fields['address_2'].required = False
		self.fields['city'].required = False
		self.fields['state'].required = False
		self.fields['zipcode'].required = False
		self.fields['country'].required = False

class PwdResetForm(PasswordResetForm):
	email = forms.EmailField(max_length=100, widget=forms.TextInput(attrs={'class': 'form-control mb-3', 'placeholder': 'Email', 'id': 'form-email'}))

	def clean_email(self):
		email = self.cleaned_data['email']
		u = UserBase.objects.filter(email=email)

		if not u:
			raise forms.ValidationError('Email address not found.')
		
		return email
	
class PwdResetConfirmForm(SetPasswordForm):
	new_password1 = forms.CharField(label='New Password', min_length=8, max_length=50, widget=forms.PasswordInput(attrs={'class': 'form-control mb-3', 'placeholder': 'New Password', 'id': 'form-newpass1'}))
	new_password2 = forms.CharField(label='Repeat Password', min_length=8, max_length=50, widget=forms.PasswordInput(attrs={'class': 'form-control mb-3', 'placeholder': 'Repeat Password', 'id': 'form-newpass2'}))