import pypdf

reader = pypdf.PdfReader("template.pdf")
page = reader.pages[0]
print(page.extract_text())