from django.db import models

def upload_to(instance, filename):
    return 'posts/{filename}'.format(filename=filename)

class Example (models.Model):
    ExampleOriginal = models.TextField(null=True)
    ExampleTranslated = models.TextField(null=True)
    
    def __str__(self):
        return self.ExampleOriginal[0:50]
    
class Dictionary (models.Model):
    Word = models.TextField(null=True)
    Translation = models.TextField(null=True)
    Example = models.ManyToManyField(Example, null=True)
    
    class Meta:
        ordering = ['Word']
    
    def __str__(self):
        return self.Word[0:50]

