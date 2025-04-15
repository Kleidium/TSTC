from django.db import models
from django.contrib.auth.models import User
from django.urls import reverse


# Create your models here. #
class DesignManager(models.Manager):
    def get_queryset(self):
        return super(DesignManager, self).get_queryset().filter(is_active=True)

class Category(models.Model):
	# Fields
	name = models.CharField(max_length=255, db_index=True)
	slug = models.SlugField(max_length=255, unique=True)

	# Metadata
	class Meta:
		verbose_name_plural = 'categories'
	
	# Methods
	def get_absolute_url(self):
		return reverse('shop:category_list', args=[self.slug])
	
	def __str__(self):
		return self.name
	

class Design(models.Model):
	# Keys
	category = models.ForeignKey(Category, related_name='design', on_delete=models.CASCADE)
	created_by = models.ForeignKey(User, related_name='design_creator', on_delete=models.CASCADE)

	# Fields
	name = models.CharField(max_length=255)
	description = models.TextField(blank=True)
	image = models.ImageField(upload_to='images/')
	slug = models.SlugField(max_length=255)
	price = models.DecimalField(max_digits=4, decimal_places=2)
	in_stock = models.BooleanField(default=True)
	is_active = models.BooleanField(default=True)
	created = models.DateTimeField(auto_now_add=True)
	updated = models.DateTimeField(auto_now=True)
	objects = models.Manager()
	designs = DesignManager()


	# Metadata
	class Meta:
		verbose_name_plural = "Designs"
		ordering = ('-updated',)

	# Methods
	def get_absolute_url(self):
		return reverse('shop:design_detail', args=[self.slug])
	
	def __str__(self):
		return self.name
