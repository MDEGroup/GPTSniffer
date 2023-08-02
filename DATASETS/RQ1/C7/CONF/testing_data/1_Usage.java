AppBarLayout abl = findViewById(R.id.app_bar);
((CoordinatorLayout.LayoutParams) abl.getLayoutParams()).setBehavior(new FixAppBarLayoutBehavior());
