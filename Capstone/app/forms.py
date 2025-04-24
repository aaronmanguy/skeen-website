from django import forms
# from django.core.validators import EmailValidator

class ContactForm(forms.Form):
    firstname = forms.CharField(max_length=100, label="", widget=forms.TextInput(attrs={'placeholder': 'First Name*', 'class': 'form-firstname'}), required=True)
    lastname = forms.CharField(max_length=100, label="", widget=forms.TextInput(attrs={'placeholder': 'Last Name*', 'class': 'form-lastname'}), required=True)
    phone = forms.CharField(max_length=100, label="",widget=forms.NumberInput(attrs={'placeholder': 'Phone'}), required=False)
    email = forms.EmailField(label="", widget=forms.TextInput(attrs={'placeholder': 'Email*'}), required=True)
    location = forms.CharField(label="", widget=forms.TextInput(attrs={'placeholder': 'Project Location*'}), required=True)
    services = forms.MultipleChoiceField(
        label="Service(s) you're interested in",
        choices=[('Surveying', 'Surveying'),
                 ('Transportation', 'Transportation'),
                 ('Land Development', 'Land Development'),
                 ('Storm Water', 'Storm Water'),
                 ('Water & Sewer', 'Water & Sewer')],
        widget=forms.CheckboxSelectMultiple(attrs={'class': 'form-checkbox'}),
        required=True
    )
    message = forms.CharField(widget=forms.Textarea(attrs={'placeholder': 'Message'}), label="", required=False)