from rest_framework import serializers

from .models import StudyRoom


class StudyRoomSerializer(serializers.Serializer):
    """
    study_room_id: 스터디룸 번호
    name: 스터디룸 이름
    location: 스터디룸 장소
    info: 스터디룸 정보
    capacity: 수용 인원
    """
    StudyRoomId = serializers.UUIDField(source='study_room_id')

    class Meta:
        model = StudyRoom
        fields = ['StudyRoomId', 'name', 'location', 'info', 'capacity']
        ref_name = 'StudyRoomSerializer'

