# классы которые определяют доспуп к данным в записимости от его учётной записи пользователя 
from rest_framework import permissions

# читать всем, изменение админу 
class IsAdminOrReadOnly(permissions.BasePermission) :
    def has_permission(self, request, view):
        # условие определяющие какой запрос прищёл (чтение)
        if request.method in permissions.SAFE_METHODS:
            return True
        
        # проверяем защёлли пользователь как одминистратор, если да то даём прово на изменение 
        return bool(request.user and request.user.is_staff)

# читать всем, изменение автору 
class IsOwnerOrReadOnLy (permissions.BasePermission) :
    def has_object_permission(self, request, view, obj):
        if request.method in permissions.SAFE_METHODS:

            return True

        return obj.owner == request.user