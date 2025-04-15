from django import forms
from .models import Contact, Transaction


class ContactForm(forms.ModelForm):
	transaction = forms.ModelChoiceField(queryset=Transaction.objects, empty_label=None, widget=forms.RadioSelect)
	
	class Meta:
		model = Contact
		fields = ['name', 'email', 'phone', 'transaction', 'comment']
		labels = {'name':'Name', 'email':'Email', 'phone':'Phone Number', 'transaction':'Transaction Type', 'comment':'Comments'}
		widgets = {'comment':forms.Textarea(attrs={'rows':5, 'cols':36, 'style':'resize:none'})}