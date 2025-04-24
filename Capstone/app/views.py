from django.shortcuts import render, redirect
from django.core.mail import send_mail, BadHeaderError, EmailMessage
from django.http import HttpResponse
# from django.contrib.auth.decorators import login_required
# from django.contrib.auth import authenticate, login, logout
# from django.contrib.auth.models import Group
from django.contrib import messages
# from .decorators import *
# from .models import *
from .forms import *
from django.shortcuts import reverse
# from django.views import View
# from django.http import JsonResponse
from django.conf import settings
from django.views.generic import TemplateView, FormView

# Create your views here.
def homeView(request):
    return render(request, "home.html")

def surveyingView(request):
    return render(request, "surveying.html")

def transportationView(request):
    return render(request, "transportation.html")

def landDevelopmentView(request):
    return render(request, "land-development.html")

def stormWaterView(request):
    return render(request, "storm-water.html")

def waterSewerView(request):
    return render(request, "water-sewer.html")

class ContactView(FormView):
    # form_class = ContactForm
    # template_name = "store/contact.html"
    # def get_success_url(self):
    #     return reverse("contact")
    # def form_valid(self, form):
    #     email = form.cleaned_data.get("email")
    #     subject = form.cleaned_data.get("subject")
    #     message = form.cleaned_data.get("message")
    #     full_message = f"""
    #         Received message below from {email}, {subject}
    #         ________________________
    #         {message}
    #         """
    #     try:
    #         send_mail(
    #             subject="Received contact form submission",
    #             message=full_message,
    #             from_email=settings.DEFAULT_FROM_EMAIL,
    #             recipient_list=[settings.CONTACT_EMAIL],
    #         )
    #     except BadHeaderError:
    #         return HttpResponse('Invalid header found.')
    #     except Exception as e:
    #         # Log the error or handle it as needed
    #         print(f"Error sending email: {e}")
    #         messages.error(self.request, "There was an error sending your message. Please try again later.")
    #         return self.form_invalid(form)
    #     return super(ContactView, self).form_valid(form) 
    
    def contactView(request):
            form = ContactForm()
            if request.method == 'POST':
                form = ContactForm(request.POST)
                if form.is_valid():
                    firstName = form.cleaned_data['firstname']
                    lastName = form.cleaned_data['lastname']
                    phone = form.cleaned_data['phone']
                    email = form.cleaned_data['email']
                    location = form.cleaned_data['location']
                    services = form.cleaned_data['services']
                    message = form.cleaned_data['message']

                    if phone:
                        full_message = f"""{firstName} {lastName} needs {services} services at {location}.
                    ---------------------------
                    {message}
                    ---------------------------
                    Contact: {email} | {phone}"""
                    else:
                        full_message = f"""{firstName} {lastName} needs {services} services at {location}.
                    ---------------------------
                    {message}
                    ---------------------------
                    Contact: {email}"""
                        
                    emailSend = EmailMessage(
                        subject = firstName + lastName,
                        body=full_message,
                        from_email=email,
                        # VV change to actual email on launch VV
                        to=['artapley06@gmail.com'],
                        reply_to=['artapley06@gmail.com']
                    )
                    try:
                        emailSend.send()
                    except BadHeaderError:
                        return HttpResponse('Invalid header found.')
                    except Exception as e:
                        # Log the error or handle it as needed
                        print(f"Error sending email: {e}")
                        return messages.error(request, "There was an error sending your message. Please try again later.")
                    
                    context = {'firstName':firstName}
                    return render(request, 'contact.html', context)

            context = {'form': form}
            return render(request, "contact.html", context)
    
    # def view_contact_page(request):
    # if request.method == "POST":
    #     message_name = request.POST['message-name']
    #     message_email = request.POST['message-email']
    #     message_subject = request.POST['message-subject']
    #     message = request.POST['message']
    #     print("Calling send_mail")
    #     # Send the email
    #     send_mail(
    #         subject=message_subject,  # Subject of the email
    #         message=message,          # Body of the email
    #         from_email=message_email, # From the email entered in the form
    #         recipient_list=['zombiejake2005@gmail.com'],  # To the admin's email
    #     )
    #     # Return a success message or render a thank you page
    #     return render(request, 'contact.html', {
    #         "message_name": message_name,
    #         "message_sent": True,  # Flag to indicate success
    #     })
    # else:
    #     return render(request, "contact.html", {})
        