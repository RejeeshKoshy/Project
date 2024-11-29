import discord
from discord.ext import commands
'''
import openai
'''
import requests
import json
'''
openai.api_key = "sk-mnopqrstuvwxabcdmnopqrstuvwxabcdmnopqrst"
'''
# To get the meme from source
def get_meme():
    response = requests.get('https://meme-api.com/gimme')
    json_data = json.loads(response.text)
    return json_data['url']

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
            elif " meme " in content:
                await message.channel.send(f"Here's a meme for you, {message.author.mention}:\n{get_meme()}")
            else:
                await message.channel.send(f"Hello {message.author.mention},I'm not sure I understand, but I'm learning!")
'''
        # Forward the user's message to OpenAI and get a response
        response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
            messages=[
                {
                    "role": "system", 
                    "content": "You are a helpful chatbot, who likes memes and hence replies in context of memes."
                },
                {"role": "user", "content": message.content}
            ]
        )

        reply = response['choices'][0]['message']['content']
        await message.channel.send(f"{reply} - {message.author.mention}")
'''

#Bot Setup
intents = discord.Intents.default()
intents.messages = True
intents.members = True
intents.message_content = True

client = MyClient(intents=intents)
token = 'MTMxMDgxMzQzNzMwMzA2MjU2OA.GmaKGy.BZM9B2gNXbQwL7Ov-00XA3BbBp_FPCCrgcZ64k'
client.run(token) # Replace with your own token.
