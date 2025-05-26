console.log("Welcome to the Community Portal");

window.onload = () => alert("Page is fully loaded!");

const today = new Date("2025-05-26");
const allEvents = [
  { name: "Music Fest", date: "2025-06-15", seats: 10, category: "music" },
  { name: "Tech Meetup", date: "2025-07-01", seats: 5, category: "tech" },
  { name: "Art Show", date: "2025-05-10", seats: 0, category: "art" }
];

// 1. Event Constructor & Prototype
function Event(name, date, seats, category) {
  this.name = name;
  this.date = date;
  this.seats = seats;
  this.category = category;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

// 2. Render Events
function renderEvents(events) {
  const container = document.getElementById("eventContainer");
  container.innerHTML = "";
  events.forEach(event => {
    const date = new Date(event.date);
    if (date > today && event.seats > 0) {
      const card = document.createElement("div");
      card.className = "eventCard";
      card.innerHTML = `
        <strong>${event.name}</strong><br>
        Date: ${event.date}<br>
        Seats: ${event.seats}<br>
        Category: ${event.category}<br>
        <button onclick="registerUser('${event.name}')">Register</button>
      `;
      container.appendChild(card);
    }
  });
}

// 3. Add Event
function addEvent(name, date, seats, category) {
  allEvents.push({ name, date, seats, category });
}

// 4. Register User
function registerUser(eventName) {
  const event = allEvents.find(e => e.name === eventName);
  try {
    if (event.seats > 0) {
      event.seats--;
      alert(`Registered for ${eventName}`);
      renderEvents(allEvents);
    } else {
      throw new Error("Event is full");
    }
  } catch (err) {
    alert(err.message);
  }
}

// 5. Filter Events by Category
function filterEventsByCategory(category, callback) {
  return allEvents.filter(e => callback(e, category));
}

// 6. Closure for Category Registration Count
function categoryCounter() {
  let count = 0;
  return () => {
    count++;
    console.log(`Registrations in category: ${count}`);
  };
}
const musicCounter = categoryCounter();

// 7. Form Submission
document.getElementById("regForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const { username, email, event } = e.target.elements;

  if (!username.value || !email.value) {
    alert("All fields required");
    return;
  }

  console.log("Form submitted", username.value, email.value, event.value);
  submitFormData({
    name: username.value,
    email: email.value,
    event: event.value
  });
});

// 8. Submit Form Data (Mock POST)
function submitFormData(data) {
  console.log("Submitting data...");
  setTimeout(() => {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      body: JSON.stringify(data),
      headers: { "Content-Type": "application/json" }
    })
      .then(res => res.json())
      .then(data => {
        alert("Registration successful!");
        console.log(data);
      })
      .catch(() => alert("Submission failed"));
  }, 1000);
}

// 9. Search Input Event
document.getElementById("searchInput").addEventListener("keydown", (e) => {
  const query = e.target.value.toLowerCase();
  const filtered = allEvents.filter(ev => ev.name.toLowerCase().includes(query));
  renderEvents(filtered);
});

// 10. Category Filter Event
document.getElementById("categoryFilter").addEventListener("change", (e) => {
  const selected = e.target.value;
  if (!selected) {
    renderEvents(allEvents);
  } else {
    const filtered = filterEventsByCategory(selected, (ev, cat) => ev.category === cat);
    renderEvents(filtered);
  }
});

// 11. jQuery Events
$('#registerBtn').click(function () {
  console.log("jQuery Click Triggered");
});

$('.eventCard').fadeIn().fadeOut(); // just demo effect

// 12. Fetch Events from Mock API using Async/Await
async function fetchEventsAsync() {
  try {
    const loader = document.createElement("p");
    loader.innerText = "Loading events from API...";
    document.body.appendChild(loader);

    const res = await fetch("https://jsonplaceholder.typicode.com/posts");
    const data = await res.json();
    console.log("Fetched Mock Events:", data.slice(0, 3));
    document.body.removeChild(loader);
  } catch (error) {
    console.error("Fetch error", error);
  }
}

fetchEventsAsync();
renderEvents(allEvents);
