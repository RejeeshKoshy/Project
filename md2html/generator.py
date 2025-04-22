import markdown
import frontmatter
from jinja2 import Template
from pathlib import Path

POSTS_DIR = Path("md_file")
TEMPLATES_DIR = Path("templates")
OUTPUT_DIR = Path("output")

def load_template(name):
    with open(TEMPLATES_DIR / name, "r", encoding="utf-8") as f:
        return Template(f.read())

def render_post(md_path):
    post = frontmatter.load(md_path)
    html_content = markdown.markdown(post.content)

    data = {
        "title": post["title"],
        "slug": post["slug"],
        "date": post["date"],
        "tags": " · ".join(post["tags"]),
        "excerpt": post["excerpt"],
        "content": html_content,
    }

    full_template = load_template("full_post_template.html")
    card_template = load_template("card_template.html")

    full_html = full_template.render(**data)
    card_html = card_template.render(**data)

    OUTPUT_DIR.mkdir(exist_ok=True)

    with open(OUTPUT_DIR / f"{post['slug']}.html", "w", encoding="utf-8") as f:
        f.write(full_html)

    with open(OUTPUT_DIR / f"{post['slug']}-card.html", "w", encoding="utf-8") as f:
        f.write(card_html)

    print(f"✅ Generated: {post['slug']}.html and card")

if __name__ == "__main__":
    for md_file in POSTS_DIR.glob("*.md"):
        render_post(md_file)