from dataclasses import field
from rest_framework.serializers import ModelSerializer
from rest_framework import serializers
from .models import *


class ExampleSerializer(ModelSerializer):
    class Meta:
        model= Example
        fields='__all__'

class DictionarySerializer(ModelSerializer):
    Dictionary_Example = ExampleSerializer(read_only=True, many=True)
    class Meta:
        model= Dictionary
        fields=('Word','Translation','Dictionary_Example',)

