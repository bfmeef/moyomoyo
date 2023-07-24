import uuid

from django.db import models


class Group(models.Model):
    group_id = models.UUIDField(primary_key=True,
                                default=uuid.uuid4,
                                unique=True,
                                editable=False)
    name = models.CharField(max_length=50)
    info = models.CharField(max_length=50)
    field = models.CharField(max_length=10)
    is_reserved = models.BooleanField(default=False)


class Member(models.Model):
    group_id = models.ForeignKey(Group, on_delete=models.CASCADE)
    user_id = models.ForeignKey()
    is_leader = models.BooleanField(default=False)


class Post(models.Model):
    post_id = models.UUIDField(primary_key=True,
                               default=uuid.uuid4,
                               unique=True,
                               editable=False)
    user_id = models.ForeignKey()
    group_id = models.ForeignKey(Group, on_delete=models.CASCADE)
    title = models.CharField(max_length=20)
    content = models.CharField(max_length=500)
    create_date = models.DateTimeField(auto_now_add=True, editable=False)
    is_notice = models.BooleanField(default=False)


class Comment(models.Model):
    comment_id = models.UUIDField(primary_key=True,
                                  default=uuid.uuid4,
                                  unique=True,
                                  editable=False)
    post_id = models.ForeignKey(Post, on_delete=models.CASCADE)
    user_id = models.ForeignKey()
    content = models.CharField(max_length=500)
    create_date = models.DateTimeField(auto_now_add=True, editable=False)
    