
import { get, del, post } from './api.js';

const tableBody = document.querySelector('tbody');
const loadBtn = document.querySelector('#loadBooks');
const form = document.querySelector('form');

loadBtn.addEventListener('click', refreshBooks);
form.addEventListener('submit', addBook);

await refreshBooks();

async function refreshBooks() {
    let books = await get('http://localhost:8080/api/books');
    tableBody.innerHTML = '';

    for (const book of books) {
        const row = document.createElement('tr');
        
        const title = document.createElement('td');
        title.textContent = book.title;
        const author = document.createElement('td');
        author.textContent = book.authorName;
        const isbn = document.createElement('td');
        isbn.textContent = book.isbn;
        const btns = document.createElement('td');
        btns.innerHTML = `<button>Edit</button>
        <button>Delete</button>`;

        let buttons = btns.querySelectorAll('button');
        buttons[0].addEventListener('click', () => console.log('edit'));
        buttons[1].addEventListener('click', async () => {
            await del('http://localhost:8080/api/books/'+book.id);
            await refreshBooks();
        });

        row.appendChild(title);
        row.appendChild(author);
        row.appendChild(isbn);
        row.appendChild(btns);

        tableBody.appendChild(row);
    }
}

async function addBook(e) {
    e.preventDefault();
    // console.log('ello');

    let book = {};
    book.title = document.querySelector('#title').value;
    book.isbn = document.querySelector('#isbn').value;
    book.authorName = document.querySelector('#author').value;

    await post('http://localhost:8080/api/books', book);
    await refreshBooks();
}