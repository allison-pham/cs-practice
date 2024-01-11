def normalizing(num_list):
    # Find max_val
    # Divide each number in the list by the max_val
    max_val = -1
    updated_list = []

    for i in num_list:
        # Find max_val
        if i > max_val:
            max_val = i

    for k in num_list:
        # Divide each number in the list by the max_val
        k = k / max_val
        updated_list.append(k)

    return updated_list
