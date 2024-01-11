def draw_triangle(width):
    # Draw upside-down isosceles triangle
    # Function calls itself at the end of this function
    # Triangle has 2 matching sides
    # width is odd

    if width == 1:
        print('*')
        # return something

    print('*' * width)
    draw_triangle(width - 2)


def main():
    draw_triangle(3)
