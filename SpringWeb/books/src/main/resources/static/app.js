
import { get, del } from './api.js';

const tableBody = document.querySelector('tbody');
const loadBtn = document.querySelector('#loadBooks');

loadBtn.addEventListener('click', refreshBooks);

async function refreshBooks(e) {
    let books = await get('http://localhost:8080/api/books');

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
        buttons[1].addEventListener('click', () => del('http://localhost:8080/api/books/'+book.id));

        row.appendChild(title);
        row.appendChild(author);
        row.appendChild(isbn);
        row.appendChild(btns);

        tableBody.appendChild(row);
    }


    
}