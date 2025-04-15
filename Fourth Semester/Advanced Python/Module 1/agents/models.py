from django.db import models

# Create your models here.
class Agent(models.Model):
	firstName = models.CharField(max_length=25)
	lastName = models.CharField(max_length=25)
	picture = models.ImageField(upload_to='images/')
	about = models.CharField(max_length=300)
	experience = models.CharField(max_length=25)
	number = models.CharField(max_length=25)
	email = models.CharField(max_length=50)