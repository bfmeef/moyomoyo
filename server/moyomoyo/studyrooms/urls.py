from django.urls import path, include
from rest_framework import routers

from .views import StudyRoomViewset


router = routers.DefaultRouter()
router.register(r'', StudyRoomViewset)

urlpatterns = router.urls
