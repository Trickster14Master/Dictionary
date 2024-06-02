from django.contrib import admin


from .models import Dictionary
admin.site.register(Dictionary)

from .models import Example
admin.site.register(Example)

