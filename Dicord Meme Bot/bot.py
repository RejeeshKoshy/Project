import discord
from discord.ext import commands
import requests
import json
from llamaapi import LlamaAPI

# Replace with your actual API token for LlamaAPI
api_token = ''
llama = LlamaAPI(api_token)

# To get the meme from source
def get_meme():
    response = requests.get('https://meme-api.com/gimme')
    if response.status_code == 200:
        json_data = json.loads(response.text)
        return json_data['url']
    else:
        return "Couldn't fetch a meme at the moment. Please try again later."

# To interact with LlamaAPI
def get_llama_response(user_message):
    try:
        # Request JSON for LlamaAPI
        api_request_json = {
            "model": "llama3.1-70b",
            "messages": [
                {"role": "system", "content": "You are a llama assistant that loves memes and talks like a llama, starting every word with 'll'."},
                {"role": "user", "content": user_message},
            ]
        }
        # Make the request to LlamaAPI
        response = llama.run(api_request_json)

        # Parse and return the response
        response_json = response.json()
        return response_json['choices'][0]['message']['content'].strip()
    except Exception as e:
        return f"An error occurred: {str(e)}"

# To interact with the user/Client
class MyClient(discord.Client):
    async def on_ready(self):
        print(f'Logged on as {self.user}!')

    async def on_message(self, message):
        # To prevent self responding
        if message.author == self.user:
            return

        # Check if the bot is mentioned
        if self.user.mentioned_in(message):
            # For easier trigger phrase detection
            content = message.content.lower()

            # Handle different trigger phrases
            if "hello" in content:
                await message.channel.send(f"Hello {message.author.mention}!")
            elif "bye" in content:
                await message.channel.send(f"Goodbye {message.author.mention}!")
            elif "meme" in content:
                await message.channel.send(f"Here's a meme for you, {message.author.mention}:\n{get_meme()}")
            else:
                llama_response = get_llama_response(message.content)
                await message.channel.send(f"{llama_response} - {message.author.mention}")

# Bot Setup
intents = discord.Intents.default()
intents.messages = True
intents.members = True
intents.message_content = True

client = MyClient(intents=intents)
token = ''  # Replace with your Discord bot token
client.run(token)
