# 📝 Blog Generator – Markdown to HTML

A lightweight side project to improve blogging efficiency by converting Markdown files into styled HTML blog posts and preview cards.

## 📁 Project Structure

```
posts/        → Markdown files with frontmatter
templates/    → Jinja2 HTML templates
output/       → Auto-generated HTML files
generator.py  → Script to generate blog post + card
watcher.py    → (Optional) Auto-regenerate on file changes
```

### 🚀 Usage

1. Write your post in `posts/` using `.md` format with frontmatter.
2. Run the generator:

```bash
python generator.py
```

3. (Optional) Enable auto-build on save:

```bash
pip install watchdog
python watcher.py
```

## 💡 Why?

A small dev-friendly tool to reduce the repetitive work of writing and formatting HTML manually for every blog post.
