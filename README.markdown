# BIN History

**BIN History** is an Android app for looking up and storing bank card BIN (Bank Identification Number) information. It fetches card details from an external API and maintains a persistent history of queries. Built with Clean Architecture, Jetpack Compose, and modern Android libraries.

---

## 🧰 Key Features

* **Card Info Screen**:
  * Users can input a 6–8 digit BIN to retrieve card details (scheme, type, brand, country, coordinates, bank info) from https://binlist.net/.
  * Interactive elements: tap on bank URL to open in a browser, phone number to dial, or coordinates to view in maps.
* **Card History Screen**:
  * Displays a list of previously queried BINs with their details.
  * Persists query history across app restarts using Room database.
* Navigation between screens using Jetpack Compose Navigation.

---

## 📁 Project Structure

```
BINHistory/
├── data/                 # Data layer
│   ├── api/              # Remote API service and models
│   │   ├── model/        # Data transfer objects (DTOs)
│   ├── local/            # Room database and DAOs
│   │   ├── model/        # Local entity models
│   ├── mapper/           # Mappers for DTO ↔ Domain ↔ Entity
│   ├── repository/       # Repository implementations
├── di/                   # Dependency injection (Hilt)
├── domain/               # Business logic layer
│   ├── model/            # Domain models
│   ├── repository/       # Repository interfaces
│   ├── usecase/          # Use cases for business logic
├── presentation/         # UI layer (Jetpack Compose)
│   ├── cardHistory/      # Card history screen and ViewModel
│   ├── cardInfo/         # Card info screen and ViewModel
│   ├── components/       # Reusable UI components
│   ├── navigation/       # Navigation setup
│   ├── ui/               # App theming
│   │   ├── theme/        # Theme definitions
```

---

## ⚙️ Technologies Used

* **Kotlin**, **Jetpack Compose** for UI.
* **Room** for local storage of query history.
* **Dagger Hilt** for dependency injection.
* **Retrofit** for API calls to https://binlist.net/.
* **Kotlin Coroutines + Flow** for asynchronous operations and state management.
* **MVVM + Clean Architecture** for modular design.

---

## 📊 Technical Highlights

* **API Integration**:
  * Fetches BIN data from https://binlist.net/ using Retrofit with Gson for JSON parsing.
* **Persistent Storage**:
  * Stores query history in a Room database, ensuring data persists across app restarts.
* **Interactive UI**:
  * Supports clickable actions for bank URLs, phone numbers, and coordinates to launch appropriate apps.
* **Clean Architecture**:
  * Separates concerns with distinct data, domain, and presentation layers.
* **State Management**:
  * Uses StateFlow in ViewModels for reactive UI updates.

---

## 📃 Code Style and Conventions

* Follows Clean Architecture with clear separation of data, domain, and presentation layers.
* Uses MVVM for UI and business logic separation.
* Employs Dagger Hilt for dependency injection.
* Leverages Jetpack Compose for declarative UI design.
* Ensures type safety with Kotlin’s nullability features.

---

## 🚀 Getting Started

1. Install Android Studio (latest stable version recommended).
2. Clone the repository:

   ```bash
   git clone https://github.com/Bphoenix134/BINHistory.git
   ```
3. Build and run the app:

   ```bash
   ./gradlew assembleDebug
   ```
4. Main entry point: `CardInfoScreen`.

---

## 📸 Screenshots

Below are screenshots showcasing the app's key screens:

| Card Info Screen | Card History Screen |
|------------------|---------------------|
| <img src="screenshots/card_info_screen.jpg" width="200"/> | <img src="screenshots/card_history_screen.jpg" width="200"/> |

---

## 📌 Notes

* All BIN queries are stored locally using Room for persistent history.
* External API (https://binlist.net/) is used for fetching card details.