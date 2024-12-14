# Project Documentation: Discord Meme Bot with Python

---

## Objective

To develop a Discord bot that interacts with users by:
1. Responding to user messages with greetings or farewells.
2. Fetching and sharing memes from an external API.
3. Integrating with Llama to generate conversational responses based on user input.

---

## Skills Gained

- **Python Programming**:
  - Using Python for creating bots and working with APIs.
- **Discord Bot Development**:
  - Understanding the `discord.py` library for building interactive bots.
- **REST API Integration**:
  - Fetching data from external APIs (e.g., Meme API).
- **Asynchronous Programming**:
  - Implementing event-driven code using Python's `asyncio`.
- **AI Integration**:
  - Working with Llama3.1-70b for enhanced bot responses.

---

## Tools and Technologies Used

- **Languages**:
  - Python
- **Libraries**:
  - `discord.py` for bot interaction with Discord servers.
  - `requests` for handling REST API calls.
  - `llamaapi` for integrating conversational AI.
- **APIs**:
  - Meme API (`https://meme-api.com/gimme`) for fetching memes.
  - Llama API for chatbot responses.
- **Platform**:
  - Discord for bot deployment and interaction.

---

## Key Features

1. **Meme Sharing**:
   - Fetches a random meme from the Meme API and shares it in the chat when prompted.

2. **User Interaction**:
   - Responds to specific phrases like "hello," "bye," or "meme" when mentioned.
   - Prevents self-response to avoid unnecessary loops.

3. **Event-Driven Design**:
   - Listens to and responds to user messages dynamically using Discord's event handling.

4. **AI Responses**:
   - Can use Llama's 3.1-70b for generating conversational and meme-themed replies.

5. **Customizable and Expandable**:
   - Easy to extend with new features like commands, additional APIs, or chatbot capabilities.

---

## How It Works

1. **Meme Fetching**:
   - Uses the `requests` library to call the Meme API and parse the JSON response to get the meme URL.

2. **User Message Handling**:
   - Listens for messages using the `on_message` event in the `discord.Client` class.
   - Responds based on trigger phrases like "hello," "bye," or "meme."

3. **AI Integration **:
   - Uses LlamaAPI's Chat completion API to generate responses, adding personality and context to interactions.

4. **Bot Setup**:
   - Utilizes Discord's `Intents` for managing permissions and interactions.
   - Runs the bot with a unique token to connect to a Discord server.

---

## Example Interaction

1. **Greeting**:
   - **User**: `@MemeBot hello`
   - **Bot**: `Hello @User!`

2. **Sharing a Meme**:
   - **User**: `@MemeBot share a meme`
   - **Bot**:  
     `Here's a meme for you, @User:`  
     *(Bot shares a random meme URL)*

3. **Farewell**:
   - **User**: `@MemeBot bye`
   - **Bot**: `Goodbye @User!`

---

## Future Enhancements

1. **Enable ChatGPT Integration**:
   - Add Llama's 3.1-70b responses to improve conversational capabilities.
2. **Additional Commands**:
   - Add commands for specific meme categories or personalized replies.
3. **Enhanced Interactivity**:
   - Implement slash commands or buttons for a better user experience.
4. **Deploy to Cloud**:
   - Host the bot on platforms like Heroku, AWS, or Azure for continuous uptime.

---

## Prerequisites

1. **Environment Setup**:
   - Install Python 3.8+.
   - Install required libraries:
     ```bash
     pip install discord requests
     ```
2. **For ChatGPT integration:**
     ```bash
     pip install llamaapi
     ```

2. **Discord Bot Token**:
   - Create a bot on the [Discord Developer Portal](https://discord.com/developers/applications) and copy its token.

3. **API Keys**:
   - Obtain an Llama API key if using Llama integration.

---

## How to Run

1. Replace the placeholders:
   - Add your Discord bot token in `client.run(token)`.
   - Add your Llama API key in the `api_key` section.

2. Run the bot:
   ```bash
   python bot.py

3. Invite the bot to your Discord server and mention it in the chat to interact!

---

## Contributions
Contributions are welcome! Please open issues or submit pull requests for bug fixes, enhancements, or new features.


### Highlights of the Documentation:
- **Clear Structure**: Organized into sections like Objective, Skills Gained, Tools Used, etc.
- **Readable Format**: Includes headings, bullet points, and code blocks for easy navigation.
- **Future-Proof**: Suggests enhancements and optional AI integration for better scalability.
- **Developer-Friendly**: Lists prerequisites and setup instructions for quick deployment.

Let me know if you need any modifications or additional details! 😊
