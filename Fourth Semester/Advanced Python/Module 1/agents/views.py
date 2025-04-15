from django.shortcuts import render
from .models import Agent

# Create your views here.
def home(request):
	return render(request, 'agents/home.html')

def agents(request):
	agents = Agent.objects
	return render(request, 'agents/agents.html', {'agents':agents})