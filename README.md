# Movie Player 3
Allow only one Library object to ever be created in your application. Add two fields -- a Name and an EmailID -- to the library, both of which can be changed by the client. The Library must always have a Name, but the EmailID may be missing. Ensure you implement appropriate getters and setters.

For any given title, there can only ever be one Movie object with that title in your application. Implement this constraint for TV Shows as well. Hint: you should not throw exceptions when the title already exists in the library.

Implement an equality criteria for watchlists based on their content. Two watchlists are considered duplicates if they aggregate the same Watchable objects in the same order, regardless of the name of the watchlists.
