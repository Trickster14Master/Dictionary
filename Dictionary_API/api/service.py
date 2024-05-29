# from warnings import filters
# from api.models import Order

# class CharFilterInFilter(filters.BaseInFilter, filters.CharFilter):
#     pass

# class OrderFilter(filters.FilterSet):
#     userToken = CharFilterInFilter(field_name='order__userToken', lookup_expr='in')

#     class Meta:
#         model = Order
#         fields = ['userToken']