import uuid

from django.db import models
from django.conf import settings


class Profile(models.Model):
    user = models.OneToOneField(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    name = models.CharField(max_length=10)
    university_name = models.CharField(max_length=20)
    major = models.CharField(max_length=20)
    caution_count = models.IntegerField(default=0)
    caution_date = models.DateTimeField()
    Profile_image = models.ImageField(blank=True)
