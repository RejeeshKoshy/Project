# Projects Overview

This repository contains diverse projects ranging from game development to machine learning, aimed at providing practical experience across various technological domains.

---

## Table of Contents

1. [Temperature Analysis and Forecasting Using Deep Learning](#1-temperature-analysis-and-forecasting-using-deep-learning)
2. [Passenger Counting using JavaScript](#2-passenger-counting-using-javascript)
3. [Facial Expression Recognition with PyTorch](#3-facial-expression-recognition-with-pytorch)
4. [Discord Meme Bot with Python](#4-discord-meme-bot-with-python)
5. [Malware Prediction and Detection Model](#5-malware-prediction-and-detection-model)
6. [Priority Based Smart Traffic System](#6-priority-based-smart-traffic-system)
7. [Markdown-to-HTML Blog Generator](#7-markdown-to-html-blog-generator)

---

### 1. Temperature Analysis and Forecasting Using Deep Learning

**Objective**  
Analyze historical temperature changes globally and build a multivariate deep learning-based time series model for forecasting average U.S. temperatures, leveraging reliable datasets and machine learning techniques.

**Skills Gained**  
- Data Collection and Preprocessing  
- Time Series Analysis  
- Deep Learning  
- Domain Knowledge  

**Tools and Technologies Used**  
- **Languages & Frameworks**:
  - Python for data processing and visualization.
  - TensorFlow or PyTorch for deep learning model development.
- **Libraries**:
  - Pandas and NumPy for data manipulation.
  - Matplotlib and Seaborn for data visualization.
- **Datasets**:
  - NOAA's Climate Data Online (CDO)
  - NASA GISS's GISTEMP dataset
  - Berkeley Earth's temperature dataset
  - European Climate Assessment & Dataset (ECA&D)
  - Climate Forecast System Reanalysis (CFSR)
- **Platforms**:
  - Jupyter Notebook for interactive coding and analysis.

**Key Features**  
- Global and Regional Climate Data Analysis  
- Advanced Deep Learning Time Series Model  
- Preprocessing Pipeline for data cleaning and augmentation  
- Visualizations of Historical and Predicted Trends  
- Actionable Insights for Climate Research  

---

### 2. Passenger Counting using JavaScript

**Objective**  
Create a simple, interactive web application to count and track passengers using JavaScript for functionality and HTML/CSS for structure and design.

**Skills Gained**  
- Structuring web applications with HTML  
- Designing interactive user interfaces with CSS  
- Adding dynamic interactivity using JavaScript (DOM manipulation and event handling)

**Tools and Technologies**  
- **HTML**: Structuring the web application.  
- **CSS**: Styling and enhancing user experience.  
- **JavaScript**: Implementing interactivity and logic.

**Key Features**  
- Real-Time Count Updates  
- Simple and User-Friendly UI  
- Interactive Buttons for Incrementing Passenger Count  
- Lightweight and Efficient Design  

---

### 3. Facial Expression Recognition with PyTorch

**Objective**  
Develop a deep learning model using PyTorch to classify facial expressions from images, applying computer vision techniques to emotion recognition tasks.

**Skills Gained**  
- Fundamentals of Deep Learning  
- Computer Vision Techniques  
- Convolutional Neural Networks (CNN)  
- Image Preprocessing and Augmentation  
- Model Training and Evaluation  

**Tools**  
- [PyTorch](https://pytorch.org/): Framework for deep learning development.  
- Datasets: FER (Facial Expression Recognition) or similar datasets.

**Key Features**  
- Image Preprocessing Pipeline (resizing, normalization, etc.)  
- CNN Model Training on Facial Expression Data  
- Evaluation Metrics (Accuracy, Confusion Matrix)  
- Scalable and Transferable Model Design  

---

### 4. Discord Meme Bot with Python

**Objective**

To develop a Discord bot that interacts with users by:
1. Responding to user messages with greetings or farewells.
2. Fetching and sharing memes from an external API.
3. (Optional) Integrating ChatGPT to generate conversational responses based on user input.

**Skills Gained**
- Python Programming
- Discord Bot Development
- REST API Integration (Fetching data from external APIs)
- Asynchronous Programming
- (Optional) AI Integration

**Tools and Technologies Used**
- **Languages**:
  - Python
- **Libraries**:
  - `discord.py` for bot interaction with Discord servers.
  - `requests` for handling REST API calls.
  - (Optional) `openai` for integrating GPT-based conversational AI.
- **APIs**:
  - Meme API (`https://meme-api.com/gimme`) for fetching memes.
  - OpenAI API (optional, for chatbot responses).
- **Platform**:
  - Discord for bot deployment and interaction.

**Key Features**
- Meme Sharing
- User Interaction
- Event-Driven Design
- (Optional) AI Responses
- Customizable and Expandable

---

### 5. Malware Prediction and Detection Model

**Objective:**
To develop a machine learning-based system for detecting malicious software by analyzing key features of software samples, thereby improving cybersecurity measures.

**Skills Gained:**
- Data preprocessing and exploratory data analysis (EDA).
- Building, training, and evaluating machine learning models.
- Implementing a RESTful API for deploying models.
- Visualizing data insights and model performance.

**Tools and Technologies Used:**
- **Languages & Frameworks:**
  - Python: For data processing and application development.
  - Flask: For API development and deployment.
- **Libraries:**
  - Pandas and NumPy: For data manipulation and preprocessing.
  - Matplotlib and Seaborn: For data visualization.
  - Scikit-learn: For implementing machine learning models.
  - XGBoost: For advanced gradient boosting classification.
- **Platforms:**
  - Google Colab: For interactive coding and analysis.

**Key Features:**
- Binary classification of software samples into benign or malicious categories.
- Preprocessing pipeline for handling missing values and scaling features.
- Implementation of Random Forest and XGBoost models.
- Comprehensive evaluation metrics like accuracy, precision, recall, and F1 score.
- Deployment of the trained model as a Flask API for real-time predictions.

**Datasets:**
- Kaggle's Malware Detection Dataset: Contains labeled samples with features such as file size, entropy, and imported libraries.

**Actionable Insights:**
- Enhances cybersecurity by accurately identifying malware.
- Demonstrates the practical application of machine learning in cybersecurity.
- Provides a scalable model for deployment in real-world scenarios.

---

### 6. Priority Based Smart Traffic System

**Objective**
To model and simulate a traffic management system that prioritizes emergency vehicles using a traffic simulator and timed signal phasing to deploy green corridors, reducing response time and traffic congestion.

**Skills Gained**
- Traffic simulation and modeling.  
- Algorithm design for dynamic signal coordination.  
- Data analysis and decision-making for smart systems.  

**Tools and Technologies Used**
- Tools: AnyLogic for traffic simulation.  
- Languages: Java or Python (for algorithm integration).  
- Platform: Centralized control system for traffic coordination.  

**Key Features**
- Traffic Simulation: Models real-world traffic scenarios to assess system efficiency.  
- Dynamic Green Corridor: Timed phasing of signals for emergency vehicle prioritization.  
- Emergency Vehicle Registration: Central database integration for secure vehicle data storage.  
- Flexible Emergency Handling: Adaptable configurations based on emergency type (ambulance, fire, police).  
- Traffic Signal Integration: Coordination across multiple intersections to optimize vehicle flow.  

---

### 7. Markdown-to-HTML Blog Generator

**Objective**  
A side project to streamline personal blogging by converting Markdown files into full HTML blog posts and preview cards, reducing repetitive manual formatting.

**Skills Gained**  
- Markdown and Frontmatter Structuring  
- HTML Templating with Jinja2  
- Python Scripting and Automation  
- Workflow Optimization  

**Tools and Technologies Used**  
- **Languages & Frameworks**: Python for script logic and content processing.
- **Libraries**:
  - `markdown` for converting Markdown to HTML.  
  - `python-frontmatter` for metadata extraction.  
  - `jinja2` for HTML templating.  
  - `watchdog` (optional) for auto-regeneration on file changes.  

**Key Features**  
- Converts `.md` files into full HTML blog posts and preview card components.  
- Separates content from layout using reusable Jinja2 templates.  
- Auto-generates output files to a designated folder.  
- Optional live watcher for auto-regeneration when content changes.

---
## License

This repository is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contributions

Contributions are welcome! Please review the [CONTRIBUTING.md](CONTRIBUTING.md) file for guidelines on submitting issues or pull requests.
