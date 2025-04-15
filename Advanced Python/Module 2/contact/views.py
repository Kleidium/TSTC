from django.shortcuts import render
from .forms import ContactForm

# Create your views here.
def contactus(request):
	if request.method =="POST":
		filled_form = ContactForm(request.POST)

		if filled_form.is_valid():
			filled_form.save()
			message = 'Submission successful. Thank you for allowing us to help with %s your home!' %(filled_form.cleaned_data['transaction'])
			error = ""
			filled_form = ContactForm()
		else:
			message = ""
			error = 'Something went wrong. Please try again.'
		
		return render(request, 'contact/contactus.html', {'contactform':filled_form, 'message':message, 'error':error})
	else:
		form = ContactForm()
		return render(request, 'contact/contactus.html', {'contactform':form})