package com.example.mystiquecatalogue_android.async.base;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler background();
    Scheduler ui();
}
