from django.contrib import admin
from django.urls import path
from app.views import *

urlpatterns = [
    path("", homeView, name="home"),
    path("surveying", surveyingView, name="survey"),
    path("transportation", transportationView, name="transportation"),
    path("land-development", landDevelopmentView, name="land-development"),
    path("storm-water", stormWaterView, name="storm-water"),
    path("water-sewer", waterSewerView, name="water-sewer"),
    path("contact", ContactView.contactView, name="contact"),
    path('admin/', admin.site.urls),
]
