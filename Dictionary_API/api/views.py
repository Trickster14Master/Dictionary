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
    # показываем что доступны все методы для работы с данными (post, get, put, delete запросы)
    queryset= Dictionary.objects.all()
    # указываем сериализатор
    serializer_class = DictionarySerializer 
    # устанавливаем классы для фильтрации 
    filter_backends = (DjangoFilterBackend, SearchFilter)
    # указываем поле по которому проводить фильтрацию 
    search_fields = ['Word']

    def get_paginated_response(self, data):
       return Response(data)
