from PIL import Image


def simple_quant(filename):
    im = Image.open(filename)
    w, h = im.size
    for row in range(h):
        for col in range(w):
            r, g, b = im.getpixel((col, row))
            r = r // 36 * 36
            g = g // 42 * 42
            b = b // 42 * 42
            im.putpixel((col, row), (r, g, b))
    im.show()

file_name = input('Enter file name: ')
simple_quant(file_name)

