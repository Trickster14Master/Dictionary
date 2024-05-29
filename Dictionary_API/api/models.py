from django.db import models

def upload_to(instance, filename):
    return 'posts/{filename}'.format(filename=filename)


class Dictionary (models.Model):
    Word = models.TextField(null=True)
    Translation = models.TextField(null=True)


