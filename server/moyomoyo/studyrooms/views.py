from rest_framework import viewsets

from .models import StudyRoom
from .serializers import StudyRoomSerializer

class StudyRoomViewset(viewsets.ModelViewSet):
    queryset = StudyRoom.objects.all()
    serializer_class = StudyRoomSerializer
    