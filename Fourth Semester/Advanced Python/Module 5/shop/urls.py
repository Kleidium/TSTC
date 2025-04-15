from django.urls import path
from . import views


app_name = 'store'


urlpatterns = [
	path('', views.all_designs, name='all_designs'),
	path('design/<slug:slug>/', views.design_detail, name='design_detail'),
	path('category/<slug:category_slug>/', views.category_list, name='category_list'),
]