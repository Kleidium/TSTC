#Program: BooksV7.py
#Course: ITSE-1373-7P1
#Author: Kc Poland
#Description: This program provides a simple GUI menu for viewing book information.
#This is the main program file.



## Imports ##
import BookClass
import tkinter as tk
from tkinter.filedialog import askopenfilename
from tkinter.messagebox import showerror, showwarning, showinfo



## Variables ##

# Book Object List
books = []
# Holds Current List Index
index = 0



## Functions ##

# Open Book File
def open_file():
    # Open File Browser
    filepath = askopenfilename(
        filetypes=[("Text Files", "*.txt")]
    )

    if not filepath:
        return
    
    # Clear Exiting List
    books.clear()

    # Populate List
    try:
        file1 = open(filepath, "r")

        for sLine in file1:
            record = sLine.strip().split(",")
            book = BookClass.Book(record[0].strip(), record[1].strip(), record[2].strip(), float(record[3].strip()), record[4].strip(), int(record[5].strip()), record[6].strip(), record[7].strip(), record[8].strip())
            books.append(book)

        file1.close()
    except:
        showerror("Error", "An error occured when attempting to read from " + filepath)

    # Check For Records
    if len(books) <= 0:
        showerror("Error", "No records found in " + filepath)
        # Clear Fields
        var_id.set("")
        var_title.set("")
        var_genre.set("")
        var_price.set("")
        var_paper.set("")
        var_onHand.set("")
        var_authorFirst.set("")
        var_authorLast.set("")
        var_publisher.set("")
        return

    # Populate Fields
    global index
    index = 0
    populateFields()

# Display Next Book's Info
def next_book():
    # Check List
    if len(books) <= 0:
        showwarning("Warning", "There are no records to view!")
        return
    
    # Check Index
    global index
    if index != len(books) - 1:
        index += 1
    else:
        showinfo("Info", "End of list reached.")
    
    # Populate Fields
    populateFields()

# Display Previous Book's Info
def prev_book():
    # Check List
    if len(books) <= 0:
        showwarning("Warning", "There are no records to view!")
        return
    
    # Check Index
    global index
    if index != 0:
        index -= 1
    else:
        showinfo("Info", "Beginning of list reached.")
    
    # Populate Fields
    populateFields()

def populateFields():
    global index

    var_id.set(books[index].sID)
    var_title.set(books[index].sTitle)
    var_genre.set(books[index].sGenre)
    var_price.set(str(books[index].fPrice))
    var_paper.set(books[index].sPaperback)
    var_onHand.set(str(books[index].iOnHand))
    var_authorFirst.set(books[index].sAuthorFirst)
    var_authorLast.set(books[index].sAuthorLast)
    var_publisher.set(books[index].sPublisher)



## GUI ##

# Top Level Window #
window = tk.Tk()
window.title("Book Viewer")
window.resizable(False, False)
window.rowconfigure(0, minsize=275, weight=1)
window.columnconfigure(1, minsize=225, weight=1)

# Field Variables #
var_id = tk.StringVar()
var_title = tk.StringVar()
var_genre = tk.StringVar()
var_price = tk.StringVar()
var_paper = tk.StringVar()
var_onHand = tk.StringVar()
var_authorFirst = tk.StringVar()
var_authorLast = tk.StringVar()
var_publisher = tk.StringVar()


# Button Frame #
frm_buttons = tk.Frame(window, relief=tk.RAISED, bd=2)
frm_buttons.grid(row=0, column=0, sticky="ns")

# Buttons
btn_open = tk.Button(frm_buttons, text="Open", command=open_file)
btn_open.grid(row=0, column=0, sticky="ew", padx=5, pady=5)

btn_next = tk.Button(frm_buttons, text="Next", command=next_book)
btn_next.grid(row=1, column=0, sticky="ew", padx=5, pady=5)

btn_prev = tk.Button(frm_buttons, text="Previous", command=prev_book)
btn_prev.grid(row=2, column=0, sticky="ew", padx=5, pady=5)


# Info Frame #
frm_info = tk.Frame(window)
frm_info.grid(row=0, column=1, sticky="nsew")

# Labels
lab_id = tk.Label(frm_info, text="ID:")
lab_id.grid(row=0, column=0, sticky="w", padx=5, pady=5)

lab_title = tk.Label(frm_info, text="Title:")
lab_title.grid(row=1, column=0, sticky="w", padx=5, pady=5)

lab_genre = tk.Label(frm_info, text="Genre:")
lab_genre.grid(row=2, column=0, sticky="w", padx=5, pady=5)

lab_price = tk.Label(frm_info, text="Price:")
lab_price.grid(row=3, column=0, sticky="w", padx=5, pady=5)

lab_paper = tk.Label(frm_info, text="Paperback:")
lab_paper.grid(row=4, column=0, sticky="w", padx=5, pady=5)

lab_onHand = tk.Label(frm_info, text="On Hand:")
lab_onHand.grid(row=5, column=0, sticky="w", padx=5, pady=5)

lab_authorFirst = tk.Label(frm_info, text="Author First:")
lab_authorFirst.grid(row=6, column=0, sticky="w", padx=5, pady=5)

lab_authorLast = tk.Label(frm_info, text="Author Last:")
lab_authorLast.grid(row=7, column=0, sticky="w", padx=5, pady=5)

lab_publisher = tk.Label(frm_info, text="Publisher:")
lab_publisher.grid(row=8, column=0, sticky="w", padx=5, pady=5)

# Fields
txt_id = tk.Entry(frm_info, textvariable=var_id)
txt_id.config(state="readonly")
txt_id.grid(row=0, column=1, sticky="e", padx=5, pady=5)

txt_title = tk.Entry(frm_info, textvariable=var_title)
txt_title.config(state="readonly")
txt_title.grid(row=1, column=1, sticky="e", padx=5, pady=5)

txt_genre = tk.Entry(frm_info, textvariable=var_genre)
txt_genre.config(state="readonly")
txt_genre.grid(row=2, column=1, sticky="e", padx=5, pady=5)

txt_price = tk.Entry(frm_info, textvariable=var_price)
txt_price.config(state="readonly")
txt_price.grid(row=3, column=1, sticky="e", padx=5, pady=5)

txt_paper = tk.Entry(frm_info, textvariable=var_paper)
txt_paper.config(state="readonly")
txt_paper.grid(row=4, column=1, sticky="e", padx=5, pady=5)

txt_onHand = tk.Entry(frm_info, textvariable=var_onHand)
txt_onHand.config(state="readonly")
txt_onHand.grid(row=5, column=1, sticky="e", padx=5, pady=5)

txt_authorFirst = tk.Entry(frm_info, textvariable=var_authorFirst)
txt_authorFirst.config(state="readonly")
txt_authorFirst.grid(row=6, column=1, sticky="e", padx=5, pady=5)

txt_authorLast = tk.Entry(frm_info, textvariable=var_authorLast)
txt_authorLast.config(state="readonly")
txt_authorLast.grid(row=7, column=1, sticky="e", padx=5, pady=5)

txt_publisher = tk.Entry(frm_info, textvariable=var_publisher)
txt_publisher.config(state="readonly")
txt_publisher.grid(row=8, column=1, sticky="e", padx=5, pady=5)


# Begin Loop #
window.mainloop()