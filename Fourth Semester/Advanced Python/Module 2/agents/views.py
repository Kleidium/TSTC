from django.shortcuts import render, get_object_or_404
from .models import Agent

# Create your views here.
def home(request):
	return render(request, 'agents/home.html')

def agents(request):
	agents = Agent.objects
	return render(request, 'agents/agents.html', {'agents':agents})

def detail(request, agent_id):
	agent_detail = get_object_or_404(Agent, pk=agent_id)
	return render(request, 'agents/detail.html', {'agent':agent_detail})