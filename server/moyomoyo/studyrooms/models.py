import uuid

from django.db import models

from accounts.models import User


class StudyRoom(models.Model):
    study_room_id = models.UUIDField(primary_key=True,
                                     default=uuid.uuid4,
                                     unique=True,
                                     editable=False)
    name = models.CharField(max_length=50)
    location = models.CharField(max_length=50)
    info = models.CharField(max_length=50)
    capacity = models.IntegerField()


class Reservation(models.Model):
    reservation_id = models.UUIDField(primary_key=True,
                                      default=uuid.uuid4,
                                      unique=True,
                                      editable=False)
    studyroom = models.ForeignKey(StudyRoom, on_delete=models.CASCADE)
    reservation_date = models.DateTimeField()
    return_date = models.DateTimeField()
    participants = models.IntegerField()
    is_used = models.BooleanField(default=False)
    is_returned = models.BooleanField(default=False)


class Participant(models.Model):
    participant_id = models.UUIDField(primary_key=True,
                                      default=uuid.uuid4,
                                      unique=True,
                                      editable=False)
    reservation_id = models.ForeignKey(Reservation, on_delete=models.CASCADE)
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    study_room_id = models.ForeignKey(StudyRoom, on_delete=models.CASCADE)
    is_leader = models.BooleanField(default=False)
