from django.db import models
from django.contrib.auth.models import (AbstractBaseUser, BaseUserManager, PermissionsMixin)
from django_countries.fields import CountryField
from django.utils.translation import gettext_lazy as _
from django.core.mail import send_mail

# Create your models here.
class CustomAccountManager(BaseUserManager):
	def create_superuser(self, email, user_name, password, **other_fields):
		other_fields.setdefault('is_staff', True)
		other_fields.setdefault('is_superuser', True)
		other_fields.setdefault('is_active', True)

		if other_fields.get('is_staff') is not True:
			raise ValueError('Superuser must be assigned to is_staff=True.')
		if other_fields.get('is_superuser') is not True:
			raise ValueError('Superuser must be assigned to is_superuser=True.')
		
		return self.create_user(email, user_name, password, **other_fields)
	
	def create_user(self, email, user_name, password, **other_fields):
		if not email:
			raise ValueError(_('You must provide an email address.'))
		
		email = self.normalize_email(email)
		user = self.model(email=email, user_name=user_name, **other_fields)
		user.set_password(password)
		user.save()

		return user


class UserBase(AbstractBaseUser, PermissionsMixin):
	# General
	email = models.EmailField(_('email address'), max_length=100, unique=True)
	user_name = models.CharField(max_length=50, unique=True)
	first_name = models.CharField(max_length=50, blank=True)
	last_name = models.CharField(max_length= 50, blank=True)
	about = models.TextField(_('about'), max_length=500, blank=True)

	# Delivery Details
	phone = models.CharField(max_length=20, blank=True)
	address_1 = models.CharField(max_length=150, blank=True)
	address_2 = models.CharField(max_length=150, blank=True)
	city = models.CharField(max_length=150, blank=True)
	state = models.CharField(max_length=150, blank=True)
	zipcode = models.CharField(max_length=12, blank=True)
	country = CountryField()

	# User Status
	is_active = models.BooleanField(default=False)
	is_staff = models.BooleanField(default=False)
	created = models.DateTimeField(auto_now_add=True)
	updated = models.DateTimeField(auto_now=True)

	objects = CustomAccountManager()

	USERNAME_FIELD = 'email'
	REQUIRED_FIELDS = ['user_name']

	class Meta:
		verbose_name = "Account"
		verbose_name_plural = "Accounts"

	def email_user(self, subject, message):
		send_mail(
            subject,
            message,
            'l@1.com',
            [self.email],
            fail_silently=False,
        )

	def __str__(self):
		return self.user_name
