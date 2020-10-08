# Step 1 select default OS image
FROM python:3.8


# Step 2 Setting up environment
#RUN apk add --no-cache python3-dev && pip3 install --upgrade pip

# Step 3 Configure a software # Defining working directory
WORKDIR /app

# Installing dependencies.
COPY /requirements.txt /app

RUN pip install -r requirements.txt

# Copying project files.
COPY ["api.py", "/app"]

# Exposing an internal port
EXPOSE 5000

# These commands will be replaced if user provides any command by himself
CMD ["python", "api.py"]