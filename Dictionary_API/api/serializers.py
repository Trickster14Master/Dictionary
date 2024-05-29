from dataclasses import field
from rest_framework.serializers import ModelSerializer
from rest_framework import serializers
from .models import *

        
class DictionarySerializer(ModelSerializer):
    class Meta:
        model= Dictionary
        fields='__all__'

