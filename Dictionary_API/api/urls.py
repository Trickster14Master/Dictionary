from . import views
from django.urls import path, include, re_path 
from rest_framework import routers

routDictionary = routers.SimpleRouter()
routDictionary.register(r'DictionaryAPI', views.DictionaryAPI)

routExample= routers.SimpleRouter()
routExample.register(r'ExampleAPI', views.ExampleAPI)

urlpatterns = [
    path("DictionaryAPI/", include(routDictionary.urls)),
    path("ExampleAPI/", include(routExample.urls)),

]