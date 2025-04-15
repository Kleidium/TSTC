from django.shortcuts import render, get_object_or_404
from .models import Category, Design


# Create your views here.
def categories(request):
	return {'categories':Category.objects.all()}


def category_list(request, category_slug):
	category = get_object_or_404(Category, slug=category_slug)
	designs = Design.objects.filter(category=category)
	return render(request, 'shop/designs/category.html', {'category':category, 'designs':designs})


def all_designs(request):
	designs = Design.objects.all()
	return render(request, 'shop/home.html', {'designs': designs})


def design_detail(request, slug):
	design = get_object_or_404(Design, slug=slug, in_stock=True)
	return render(request, 'shop/designs/detail.html', {'design':design})