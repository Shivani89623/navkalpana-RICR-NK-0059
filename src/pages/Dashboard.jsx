import { useEffect, useState } from "react";
import API from "../api/Axoisinstance";
import Navbar from "../components/Navbar";

export default function Dashboard() {
  const [summary, setSummary] = useState({});

  useEffect(() => {
    API.get("/dashboard/summary")
      .then(res => setSummary(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div>
        <div>
      <Navbar />
      <h2>Dashboard Content Here</h2>
    </div>
      <h2>Dashboard</h2>
      <p>Total Batches: {summary.totalBatches}</p>
      <p>Active: {summary.activeBatches}</p>
      <p>Completed: {summary.completedBatches}</p>
    </div>
  );
}

