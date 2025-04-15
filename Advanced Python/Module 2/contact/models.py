from django.db import models

# Create your models here.
class Transaction(models.Model):
	title = models.CharField(max_length=16)

	def __str__(self):
		return self.title


class Contact(models.Model):
	name = models.CharField(max_length=50)
	email = models.EmailField(max_length=50)
	phone = models.CharField(max_length=25)
	transaction = models.ForeignKey(Transaction, on_delete=models.CASCADE)
	comment = models.CharField(max_length=300)

	def __str__(self):
		return self.name