from . import views
from django.urls import path, include, re_path 
from rest_framework import routers

routDictionary = routers.SimpleRouter()
routDictionary.register(r'DictionaryAPI', views.DictionaryAPI)

urlpatterns = [
    path("DictionaryAPI/", include(routDictionary.urls)),
]