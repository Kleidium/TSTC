# Generated by Django 4.2.6 on 2023-11-04 02:03

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('shop', '0001_initial'),
    ]

    operations = [
        migrations.AlterModelOptions(
            name='design',
            options={'ordering': ('-updated',), 'verbose_name_plural': 'Designs'},
        ),
    ]
