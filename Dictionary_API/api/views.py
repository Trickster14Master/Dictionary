from rest_framework.decorators import api_view
from rest_framework import viewsets
from rest_framework.response import Response
from rest_framework.permissions import *
from rest_framework.authentication import TokenAuthentication
from api.permissions import IsAdminOrReadOnly
from .serializers import *
from django_filters.rest_framework import DjangoFilterBackend
from rest_framework.filters import SearchFilter
   
class DictionaryAPI(viewsets.ModelViewSet):
    queryset= Dictionary.objects.all()
    serializer_class = DictionarySerializer 
    filter_backends = (DjangoFilterBackend, SearchFilter)
    search_fields = ['Word']

    def get_paginated_response(self, data):
       return Response(data)
   
class ExampleAPI(viewsets.ModelViewSet):
    queryset= Dictionary.objects.all()
    serializer_class = ExampleSerializer 

    def get_paginated_response(self, data):
       return Response(data)
